import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { RegisterDto } from '../models/register-dto';
import { AuthResponse } from '../models/authresponse';
import { Result } from '../models/result';
import { Logindto } from '../models/logindto';
import { jwtDecode } from 'jwt-decode';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private apiService: ApiService
  ) { }

  jwt: string = '';
  private loggedSubject = new BehaviorSubject<boolean>(this.userExists());
  logged$ = this.loggedSubject.asObservable();

  async login(data: Logindto): Promise<AuthResponse>{
    try{
      const request: Result<AuthResponse> = await this.apiService.post<AuthResponse>(`api/Auth/login`, data);
      const result: AuthResponse = request.data

      this.apiService.jwt = result.token;
      this.jwt = this.apiService.jwt;

      if (data.remember) {
        localStorage.setItem('token', this.jwt);
      } else {
        sessionStorage.setItem('token', this.jwt)
      }
      
      this.loggedSubject.next(true);
      return result;
    } catch (error)
    {
      console.error('Error logging in');
      return null;
    }
  }

  async register(data: RegisterDto): Promise<AuthResponse>{
    try {
      const request: Result<AuthResponse> = await this.apiService.post<AuthResponse>(`api/Auth/register`, data);
      const result: AuthResponse = request.data;

      this.apiService.jwt = result.token;
      this.jwt = this.apiService.jwt;

      if (data.remember) {
            localStorage.setItem('token', this.jwt);
          } else {
            sessionStorage.setItem('token', this.jwt);
          }

          this.loggedSubject.next(true);
        return result;
    } catch (error: any) {
        console.log("Error en el registro")
        return null;
    }
    
  }
  async logout(): Promise<void> {
    console.log("Logging out");
    sessionStorage.removeItem('token');
    localStorage.removeItem('token');
    this.apiService.jwt = null;
    this.loggedSubject.next(false);
  }

  localAndSessionStorage(){
    const localtoken: string = localStorage.getItem('token')
    const sessiontoken: string = sessionStorage.getItem('token')

    if (localtoken != "" && localtoken != null || sessiontoken != "" && sessiontoken != null) {
      
      if (localtoken != "" && localtoken != null) {
        return localtoken
      }
      else if(sessiontoken != "" && sessiontoken != null) {
        return sessiontoken
      }
      else {
        return ""
      }

    } else {
      return ""
    }
  }
  userExists(){
    this.jwt = this.localAndSessionStorage();
    if (this.jwt != "" && this.jwt != null) {

      const decodeadoJwt: any = jwtDecode(this.jwt)

      if (decodeadoJwt == "" || decodeadoJwt == null) {
        return false
      } else {
        return true
      }

    } else {
      
      return false

    }
  }
}
