import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { RegisterDto } from '../../models/register-dto';

@Component({
  selector: 'app-register',
  imports: [RouterModule, FormsModule, ReactiveFormsModule, NgIf],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  form: FormGroup;
  remember: boolean = false;
  logged: boolean = false;

  constructor( 
    private authService: AuthService,
    public fb: FormBuilder,
    private router: Router
  ){
      this.form = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(4)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      password2: ['', [Validators.required]]
      }, { validators: this.passwordMatchValidator });
    }

    ngOnInit(): void {
    if (this.authService.jwt != "" && this.authService.jwt != null) {
      this.logged = true;
    }
  }

  passwordMatchValidator(form: FormGroup) {
    const password = form.get('password')?.value;
    const password2 = form.get('password2')?.value;
    return password === password2 ? null : { passwordMismatch: true };
  }

  async submit() {
    if (this.form.invalid) return;

    const register: RegisterDto = {
      username: this.form.get('nombreUsuario')?.value,
      email: this.form.get('correo')?.value,
      password: this.form.get('password')?.value,
      remember: this.remember
    };

    try {
      await this.authService.register(register);
      await this.router.navigateByUrl('');
    } catch (error) {
    }
  }
}
