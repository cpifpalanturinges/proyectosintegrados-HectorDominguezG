import { Routes } from '@angular/router';
import { InicioComponent } from './pages/inicio/inicio.component';
import { RecetasComponent } from './pages/recetas/recetas.component';
import { DespensaComponent } from './pages/despensa/despensa.component';
import { ForoComponent } from './pages/foro/foro.component';

export const routes: Routes = [
    {path: '', component: InicioComponent},
    {path: 'recetas', component: RecetasComponent},
    {path: 'despensa', component: DespensaComponent},
    {path: 'foro', component: ForoComponent}
];
