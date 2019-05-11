import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LogInComponent } from './log-in/log-in.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { MaterialsPageComponent } from './materials-page/materials-page.component';
import { MaterialDetailComponent } from './material-detail/material-detail.component';
import { FacultiesComponent } from './faculties/faculties.component';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { AllUsersComponent} from './admin-panel/all-users/all-users.component';
 

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LogInComponent, data: { animation: { value: 'LoginPage' }} },
  { path: 'home', component: HomeComponent, data: { animation: { value: 'HomePage' }} },
  { path: 'register', component: RegisterComponent, data: { animation: { value: 'RegisterPage' }} },
  { path: 'materials', component: MaterialsPageComponent, data: { animation: { value: 'MaterialsPage' }} },
  { path: 'materials/subject/:id', component: MaterialDetailComponent, data: { animation: { value: 'MaterialDetailPage' }} },
  { path: 'faculties', component: FacultiesComponent, data: { animation: { value: 'MaterialDetailPage' }} },
  { path: 'admin-panel', component: AdminPanelComponent, data: { animation: { value: 'AdminPanelPage' }} },
  { path: 'admin-panel/all-users', component:AllUsersComponent, data: {animation : {value:'AllUsersPage'}}}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
