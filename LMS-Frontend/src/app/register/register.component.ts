import { Component, OnInit } from '@angular/core';
import { User } from '../model/user'
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms'
import { AdminService } from '../admin-service/admin.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  public user: User = new User();
  hide = true;
  
  registerForm: FormGroup;

  constructor(
    private adminService: AdminService,
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit() {

    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      re_password: ['', Validators.required],
      re_email: ['', Validators.required, Validators.email],
      email: ['', Validators.required, Validators.email],
      role: ['', Validators.required]
    });
  }

  onSubmit(){
    const user = this.registerForm.value;
    delete user['re_password'];
    delete user['re_email'];
    this.user = user;
    this.adminService.addNewUser(this.user).subscribe();
    alert("You have created a user")
  }

}
