import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { DataService } from '../../provider/data.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  user:{
    name:string,
    email:string,
    pass:string,
    imgUrl:string
  };
  
  registerForm: FormGroup
  constructor(public data:DataService) { 
    
  }

  createFormGroup() {
    return new FormGroup({
        name:new FormControl(),
        email:new FormControl(),
        pass:new FormControl(),
        imgUrl:new FormControl()

    });
  }

  register()
  {
    
    this.user = this.registerForm.value;
    this.data.registerUser(this.user)
    .subscribe(
      result => {
        console.log(result);
        alert("Registered!");
      },
      error=>{
        console.error();
        alert("Error!");
      }
    );
  }

  ngOnInit() {
    this.registerForm = this.createFormGroup();

    var body = document.getElementsByTagName('body')[0];
    body.classList.add('login-page');

    var navbar = document.getElementsByTagName('nav')[0];
    navbar.classList.add('navbar-transparent');
}
ngOnDestroy(){
    var body = document.getElementsByTagName('body')[0];
    body.classList.remove('login-page');

    var navbar = document.getElementsByTagName('nav')[0];
    navbar.classList.remove('navbar-transparent');
}

}
