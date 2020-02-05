import { Injectable } from '@angular/core';
import { HttpClient ,HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PrestamosService {

  private _url = 'http://127.0.0.1:8080/api/prestamos'

  constructor(private _httpClient: HttpClient) { }

  getProximoNroPrestamo(){
    return this._httpClient.get(this._url+ "/proximoNro")
  }

  operacionPrestamo(prestamo){    
    let params = JSON.stringify(prestamo);
    let headers = new HttpHeaders().set('Content-Type', 'application/json',);
    return this._httpClient.post<any>(this._url+'/operacion', params, {headers:headers});    
  }

}
