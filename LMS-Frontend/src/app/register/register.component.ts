import { Component, OnInit } from '@angular/core';
import { User } from '../model/user'
import { FormGroup, FormBuilder, Validators } from '@angular/forms'
import { AdminService } from '../services/admin-service/admin.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  user: User = new User();
  hide = true;

  registerForm: FormGroup;

  constructor(
    private adminService: AdminService,
    private fb: FormBuilder
  ) {
  }

  ngOnInit() {
    this.registerForm = this.fb.group({
      username: [null, [Validators.required, Validators.minLength(6)]],
      password: [null, [Validators.required, Validators.minLength(8)]],
      confirmPassword: [null, Validators.minLength(8)],
      email: [null, [Validators.required, Validators.email]],
      role: [null, Validators.required]
    });
  }

  onSubmit() {
        const user = this.registerForm.value;
        delete user['re_password'];
        this.user = user;
        this.adminService.addNewUser(this.user).subscribe();
        alert("You have created a user")
      }


}
