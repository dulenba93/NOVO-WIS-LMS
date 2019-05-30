import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LogInComponent } from './log-in/log-in.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './admin-panel/register/register.component';
import { MaterialsPageComponent } from './materials-page/materials-page.component';
import { MaterialDetailComponent } from './material-detail/material-detail.component';
import { FacultiesComponent } from './faculties/faculties.component';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import { TeacherPanelComponent } from './teacher-panel/teacher-panel.component';
import { StudentPanelComponent } from './student-panel/student-panel.component';
import { UniversityComponent} from './admin-panel/university/university/university.component';
import { AddUniversityComponent} from './admin-panel/university/add-university/add-university.component';
import { UserManagementComponent } from './admin-panel/user-management/user-management.component';
import { AddFacultyComponent } from './faculties/add-faculty/add-faculty.component';
import { AddAddressComponent } from './admin-panel/add-address/add-address.component';
import { StudyProgramComponent } from './faculties/study-program/study-program.component';
import { AddStudyProgramComponent } from './faculties/study-program/add-study-program/add-study-program.component';

 

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LogInComponent, data: { animation: { value: 'LoginPage' }} },
  { path: 'home', component: HomeComponent, data: { animation: { value: 'HomePage' }} },
  { path: 'admin-panel/register', component: RegisterComponent, data: { animation: { value: 'RegisterPage' }} },
  { path: 'admin-panel/user-management', component: UserManagementComponent, data: { animation: { value: 'UserManagementPage' }} },
  { path: 'materials', component: MaterialsPageComponent, data: { animation: { value: 'MaterialsPage' }} },
  { path: 'materials/subject/:id', component: MaterialDetailComponent, data: { animation: { value: 'MaterialDetailPage' }} },
  { path: 'faculties', component: FacultiesComponent, data: { animation: { value: 'FacultiesPage' }} },
  { path: 'faculties/:universityId', component: FacultiesComponent, data: { animation: { value: 'FacultiesPage' }} },
  { path: 'faculties/:name', component: FacultiesComponent, data: { animation: { value: 'SingleFacultyPage' }} },
  { path: 'admin-panel', component: AdminPanelComponent, data: { animation: { value: 'AdminPanelPage' }} },
  { path: 'teacher-panel', component: TeacherPanelComponent, data: { animation: { value: 'TeacherPanelPage' }} },
  { path: 'student-panel', component: StudentPanelComponent, data: { animation: { value: 'StudentPanelPage' }} },
  { path: 'admin-panel/university', component:UniversityComponent, data: {animation : {value:'UniversityPage'}}},
  { path: 'admin-panel/university/add-university', component:AddUniversityComponent, data: {animation : {value:'AddUniversityPage'}}},
  { path: 'admin-panel/university/add-faculty', component:AddFacultyComponent, data: {animation : {value:'AddFacultyPage'}}},
  { path: 'admin-panel/add-address', component: AddAddressComponent, data: { animation: { value: 'AddAddressPage' }} },
  { path: 'faculties/:universityId/study-program', component: StudyProgramComponent, data: { animation: { value: 'StudyProgramPage' }} },
  { path: 'faculties/:universityId/study-program/:facultyId', component: StudyProgramComponent, data: { animation: { value: 'StudyProgramPage' }} },
  { path: 'faculties/:universityId/study-program/:facultyId/add-study-program', component: AddStudyProgramComponent, data: { animation: { value: 'AddStudyProgramPage' }} }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
