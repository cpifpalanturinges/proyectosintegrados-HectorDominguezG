import { Routes } from '@angular/router';
import { InicioComponent } from './pages/inicio/inicio.component';
import { RecetasComponent } from './pages/recetas/recetas.component';
import { DespensaComponent } from './pages/despensa/despensa.component';
import { ForoComponent } from './pages/foro/foro.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';

export const routes: Routes = [
    {path: '', component: InicioComponent},
    {path: 'recetas', component: RecetasComponent},
    {path: 'despensa', component: DespensaComponent},
    {path: 'foro', component: ForoComponent},
    {path: 'login', component: LoginComponent},
    {path: 'register', component: RegisterComponent}
];
