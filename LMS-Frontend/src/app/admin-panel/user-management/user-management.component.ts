import { Component, OnInit } from '@angular/core';
import { Student } from '../../model/student';
import { UserManagementService } from '../../services/user-management-service/user-management.service';
import { Teacher } from '../../model/teacher';
import { Administration } from '../../model/administration';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.scss']
})
export class UserManagementComponent implements OnInit {

  displayedColumns1: string[] = ['id','firstName','lastName', 'email', 'cardNumber', 'details', 'update','delete'];
  displayedColumns2: string[] = ['id', 'firstName', 'lastName', 'email', 'personalIdentificationNumber', 'details', 'update','delete'];

  students: Student[];
  teachers: Teacher[];
  administrative: Administration[];

  constructor(
    private userManagementService: UserManagementService
    ) {}

  ngOnInit() {
    this.getStudents();
    this.getTeachers();
    this.getAdministrative();
  }

  getStudents(){
    this.userManagementService.getAllStudents()
    .subscribe(students => this.students = students);
  }

  getTeachers(){
    this.userManagementService.getAllTeachers()
    .subscribe(teachers => this.teachers = teachers);
  }

  getAdministrative(){
    this.userManagementService.getAllAdministrative()
    .subscribe(administrative => this.administrative = administrative);
  }

}
