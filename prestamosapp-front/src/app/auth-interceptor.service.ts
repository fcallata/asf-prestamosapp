import { Injectable, Injector } from '@angular/core';
import { HttpInterceptor} from '@angular/common/http'
import { AuthService } from './services/auth.service'

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor{

  constructor(private _injector: Injector) { }

  intercept(req, next){
    let authService = this._injector.get(AuthService)
    let tokenizedReq = req.clone({
      setHeaders: {
        Authorization: `${authService.getToken()}`
      }
    })
    return next.handle(tokenizedReq)
  }
}
