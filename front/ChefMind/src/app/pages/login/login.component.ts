import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterModule, Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { NgIf } from '@angular/common';
import { Logindto } from '../../models/logindto';

@Component({
  selector: 'app-login',
  imports: [RouterModule, FormsModule, ReactiveFormsModule, NgIf],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  form: FormGroup;
  remember: boolean = false;
  logged: boolean = false;

  constructor(
    private authService: AuthService,
    public fb: FormBuilder,
    private router: Router 
  ){
    this.form = this.fb.group({
      email: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }
  ngOnInit(): void {
    if (this.authService.jwt != '' && this.authService.jwt != null) {
      this.logged = true;
    }
  }
  public async submit(){
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const data: Logindto = {
      emailOrUserName: this.form.get('email')?.value,
      password: this.form.get('password')?.value,
      remember: this.remember,
    };

    try {
      await this.authService.login(data);
      await this.router.navigateByUrl('');
    } catch (error) {
      console.error('Error en login:', error);
    }

  }
}
