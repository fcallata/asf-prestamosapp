import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersonasService {

  private url = "http://127.0.0.1:8080/api/personas"

  constructor(private _http: HttpClient) { }


  getPersona(nroIdentificacion){
    return this._http.get(this.url+ "/" + nroIdentificacion);    
  }

  getAll(){
    return this._http.get(this.url);
  }

}
