import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-inicio',
  imports: [RouterOutlet, RouterModule],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css'
})
export class InicioComponent {
  logged: boolean = false
  constructor(public authService: AuthService){}

  ngOnInit():void {
    this.authService.logged$.subscribe(value => {
    this.logged = value;
  });
  }

}
