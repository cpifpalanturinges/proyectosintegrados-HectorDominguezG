import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { RegisterDto } from '../models/register-dto';
import { AuthResponse } from '../models/authresponse';
import { Result } from '../models/result';
import { Logindto } from '../models/logindto';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private apiService: ApiService
  ) { }

  jwt: string = '';

  async login(data: Logindto): Promise<AuthResponse>{
    try{
      const request: Result<AuthResponse> = await this.apiService.post<AuthResponse>(`Auth/login`, data);
      const result: AuthResponse = request.data

      this.apiService.jwt = result.token;
      this.jwt = this.apiService.jwt;

      if (data.remember) {
        localStorage.setItem('token', this.jwt);
      } else {
        sessionStorage.setItem('token', this.jwt)
      }

      return result;
    } catch (error)
    {
      console.error('Error logging in');
      return null;
    }
  }

  async register(data: RegisterDto): Promise<AuthResponse>{
    try {
      const request: Result<AuthResponse> = await this.apiService.post<AuthResponse>(`Auth/register`, data);
      const result: AuthResponse = request.data;

      this.apiService.jwt = result.token;
      this.jwt = this.apiService.jwt;

      if (data.remember) {
            localStorage.setItem('token', this.jwt);
          } else {
            sessionStorage.setItem('token', this.jwt);
          }

        return result;
    } catch (error: any) {
        console.log("Error en el registro")
        return null;
    }
  }
}
