import { Component, OnInit } from '@angular/core';
import { FormGroup,  FormControl,  Validators } from '@angular/forms';
import { PrestamosService } from '../../services/prestamos.service'
import { PersonasService } from 'src/app/services/personas.service';

@Component({
  selector: 'app-prestamos',
  templateUrl: './prestamos.component.html',
  styleUrls: ['./prestamos.component.css']
})
export class PrestamosComponent implements OnInit {

  numeroPrestamo: any
  prestamoForm: FormGroup
  datos: any

  constructor(private _prestamosService: PrestamosService, private _personasService: PersonasService) { }

  ngOnInit() {
    
    this.getProximoNroPersona()

    this.prestamoForm = new FormGroup({
      valorPrestamo: new FormControl('', [Validators.required]),
      nroIdentificacion: new FormControl('', [Validators.required]),
      nombre: new FormControl('',[Validators.required]),
      primerApellido: new FormControl('', [Validators.required]),
      segundoApellido: new FormControl('', [Validators.required]),
      telCasa: new FormControl('', [Validators.required]),
      telMovil: new FormControl('', [Validators.required]),
      fechaAutorizacion: new FormControl('', [Validators.required])
    })

    this.getAllPersonas()
  }

  getProximoNroPersona(){
    this._prestamosService.getProximoNroPrestamo().subscribe(
      res => {
        this.numeroPrestamo = res
      },
      error => {
        console.log('error')
      }
    )
  }

  getPersona(){
    this._personasService.getPersona("31541622").subscribe(
      res => {
        console.log(res)
      },
      error => {
        console.log("error");
      }
    )
  }

  onSubmit = (formValue) => {
    console.log('Submit')    
    if (this.prestamoForm.valid) {
      this._prestamosService.operacionPrestamo(formValue).subscribe(
        data => {
                    
          console.log(data.status);
          if(data.status === 'error'){
            alert(data.message)
          }else{
            if(data.status === 'success'){
              alert(data.message)
              this.prestamoForm.reset()
              this.getProximoNroPersona()
            }
          }
          
        },
        error => {
          console.log("error"+ error.status);
        }
      )     
    }

  }

  getAllPersonas(){
    this._personasService.getAll().subscribe(
      res => {
        console.log(res)
      },
      error => {
        console.log("error personas")
        
      }
    )
  }

}
