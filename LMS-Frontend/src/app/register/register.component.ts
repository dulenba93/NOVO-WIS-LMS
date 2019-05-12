import { Component, OnInit } from '@angular/core';
import { User } from '../model/user'
import { FormGroup, FormBuilder, Validators, FormControl, FormGroupDirective, NgForm } from '@angular/forms'
import { AdminService } from '../services/admin-service/admin.service';
import { ErrorStateMatcher } from '@angular/material/core';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const invalidCtrl = !!(control && control.invalid && control.parent.dirty);
    const invalidParent = !!(control && control.parent && control.parent.invalid && control.parent.dirty);

    return (invalidCtrl || invalidParent);
  }
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  user: User = new User();
  hide = true;

  registerForm: FormGroup;

  matcher = new MyErrorStateMatcher();

  constructor(
    private adminService: AdminService,
    private fb: FormBuilder
  ) {
  }

  ngOnInit() {
    this.registerForm = this.fb.group({
      username: [null, [Validators.required, Validators.minLength(6)]],
      password: [null, [Validators.required, Validators.minLength(8)]],
      confirmPassword: [null, [Validators.required, Validators.minLength(8)]],
      email: [null, [Validators.required, Validators.email]],
      role: [null, Validators.required]
    },
      { validator: this.checkPasswords });
  }

  onSubmit() {
    const user = this.registerForm.value;
    delete user['re_password'];
    this.user = user;
    this.adminService.addNewUser(this.user).subscribe();
  }

  checkPasswords(group: FormGroup) { 
    let pass = group.controls.password.value;
    let confirmPass = group.controls.confirmPassword.value;

    return pass === confirmPass ? null : { notSame: true }
  }


}
