import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LogInComponent } from './log-in/log-in.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { MaterialsPageComponent } from './materials-page/materials-page.component';
import { MaterialDetailComponent } from './material-detail/material-detail.component';
import { FacultiesComponent } from './faculties/faculties.component';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { TeacherPanelComponent } from './teacher-panel/teacher-panel.component';
import { StudentPanelComponent } from './student-panel/student-panel.component';
import { UniversityComponent} from './admin-panel/university/university/university.component';
import { AddUniversityComponent} from './admin-panel/university/add-university/add-university.component';
 

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LogInComponent, data: { animation: { value: 'LoginPage' }} },
  { path: 'home', component: HomeComponent, data: { animation: { value: 'HomePage' }} },
  { path: 'register', component: RegisterComponent, data: { animation: { value: 'RegisterPage' }} },
  { path: 'materials', component: MaterialsPageComponent, data: { animation: { value: 'MaterialsPage' }} },
  { path: 'materials/subject/:id', component: MaterialDetailComponent, data: { animation: { value: 'MaterialDetailPage' }} },
  { path: 'faculties', component: FacultiesComponent, data: { animation: { value: 'FacultiesPage' }} },
  { path: 'faculties/:name', component: FacultiesComponent, data: { animation: { value: 'SingleFacultyPage' }} },
  { path: 'admin-panel', component: AdminPanelComponent, data: { animation: { value: 'AdminPanelPage' }} },
  { path: 'teacher-panel', component: TeacherPanelComponent, data: { animation: { value: 'TeacherPanelPage' }} },
  { path: 'student-panel', component: StudentPanelComponent, data: { animation: { value: 'StudentPanelPage' }} },
  { path: 'admin-panel/university', component:UniversityComponent, data: {animation : {value:'UniversityPage'}}},
  { path: 'admin-panel/university/add-university', component:AddUniversityComponent, data: {animation : {value:'AddUniversityPage'}}}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
