package com.aconcaguasf.prestamosapp.controller;

import com.aconcaguasf.prestamosapp.constante.ConstantesPrestamo;
import com.aconcaguasf.prestamosapp.controller.base.BaseController;
import com.aconcaguasf.prestamosapp.model.dominio.Persona;
import com.aconcaguasf.prestamosapp.model.dominio.Prestamo;
import com.aconcaguasf.prestamosapp.model.dto.PrestamoPersonaDTO;
import com.aconcaguasf.prestamosapp.util.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamosController extends BaseController {

    private static final Logger logger = LogManager.getLogger(PrestamosController.class);

    /**
     * Obtiene el proximo nro de prestamo, solo sirve para mostrar en la vista.
     * @return
     */
    @GetMapping("/proximoNro")
    public Long ultimoNroPrestamo(){
        return super.prestamoService.getUltimoPrestamo();
    }

    /**
     * Metodo principal que se encarga de crear la operacion de prestamo.
     * @param prestamoDTO
     * @return
     */
    @PostMapping(value = "/operacion")
    public Map<String, Object> crearOperacion(@RequestBody PrestamoPersonaDTO prestamoDTO){
        logger.info("Metodo crearOperacion: " + prestamoDTO.getValorPrestamo() + " "
                + prestamoDTO.getValorPrestamo().getClass().getName() + " "
                + prestamoDTO.getFechaAutorizacion());


        Map<String, Object> mapJson = new HashMap<>();
        BigDecimal prestamoCantidad = prestamoDTO.getValorPrestamo();
        String fecha = prestamoDTO.getFechaAutorizacion();
        LocalDate fechaAutorizacion = DateUtil.getFechaLocalDate(fecha, "dd/MM/yyyy");
        BigDecimal valorMaximo = configuracionService.getValormaximo(ConstantesPrestamo.ID_CONFIGURACION_VALOR_MAXIMO);

        Persona persona;
        Prestamo prestamo;

        try {
            if (prestamoCantidad.compareTo(valorMaximo) == -1){
                if(dayEnabled(fechaAutorizacion.getDayOfMonth())){
                    persona = new Persona();
                    persona.setNroIdentificacion(prestamoDTO.getNroIdentificacion());
                    persona.setNombre(prestamoDTO.getNombre());
                    persona.setPrimerApellido(prestamoDTO.getPrimerApellido());
                    persona.setSegundoApellido(prestamoDTO.getSegundoApellido());
                    persona.setTelCasa(prestamoDTO.getTelCasa());
                    persona.setTelMovil(prestamoDTO.getTelMovil());

                    prestamo = new Prestamo();
                    prestamo.setFechaAutorizacion(fechaAutorizacion);
                    prestamo.setValorPrestamo(prestamoCantidad);
                    prestamo.setFechaEntrega(fechaentrega(fechaAutorizacion));
                    prestamo.setFechasPago(proximasFechasPago(prestamo.getFechaEntrega()));

                    prestamoService.save(prestamo, persona);

                    mapJson.put("status","success");
                    mapJson.put("message","La operación se realizo con exito.");
                    return mapJson;
                }else{
                    mapJson.put("status","error");
                    mapJson.put("message","El dia de autorización de estar entre el 1 y 20 de cada mes.");
                    return mapJson;
                }
            }else{
                mapJson.put("status","error");
                mapJson.put("message","El valor supera el maximo para prestar.");
                return mapJson;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Calcula las fechas de los pagos de las cuotas a partir de la entrega.
     * @param fecha
     * @return
     */
    private String proximasFechasPago(LocalDate fecha){
        StringBuffer pagoFechas = new StringBuffer("");
        for (int i=0; i < ConstantesPrestamo.CANTIDAD_CUOTAS; i++){
            fecha = fecha.plusDays(30);
            if (i == 0)
                pagoFechas.append(DateUtil.getFechaLocalDateTexto(fecha,"dd/MM/yyyy"));
            else{
                pagoFechas.append(", "+ DateUtil.getFechaLocalDateTexto(fecha,"dd/MM/yyyy"));
            }
        }
        logger.info("proximas: " + pagoFechas);
        return pagoFechas.toString();
    }

    /**
     * Calcula la fecha de entrega a partir de la fecha de autorización.
     * @param fechaAutorizacion
     * @return
     */
    private LocalDate fechaentrega(LocalDate fechaAutorizacion){

        LocalDate fechaEntrega = fechaAutorizacion.plusDays(ConstantesPrestamo.CANTIDAD_DIAS_ENTREGA);
        logger.info("fecha de entrega: " + fechaEntrega);
        return fechaEntrega;
    }

    /**
     * Se fija si el dia de autorización estan en el rango del 1 y 20
     * @param day
     * @return
     */
    private boolean dayEnabled(int day){
        if (day >= ConstantesPrestamo.DIA_INICIAL_HABILIDATO && day <= ConstantesPrestamo.DIA_FINAL_HABILIDATO){
            return true;
        }else {
            return false;
        }
    }

}
