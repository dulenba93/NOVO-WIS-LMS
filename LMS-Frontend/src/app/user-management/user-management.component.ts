import { Component, OnInit } from '@angular/core';
import { Student } from '../model/student';
import { UserManagementService } from '../services/user-management-service/user-management.service';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.scss']
})
export class UserManagementComponent implements OnInit {

  students: Student[];

  constructor(
    private userManagementService: UserManagementService,
    ) {
   }

  ngOnInit() {
  }

}
