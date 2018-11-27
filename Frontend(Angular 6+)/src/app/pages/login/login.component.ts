import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { DataService } from '../../provider/data.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

    date : Date = new Date();
    focus;
    focus1;
    userData:any;
    loginForm:FormGroup;

    constructor(public data:DataService, private formBuilder: FormBuilder, private router:Router) { }

    ngOnInit() {

        this.loginForm = this.createFormGroup();
        
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

    createFormGroup() {
        return new FormGroup({
            email: new FormControl(),
            password:new FormControl()
        });
      }
    
      login()
      {
        this.data.getLoginDetailsUsingUnameOrEmail(this.loginForm.value.email).subscribe(
          result =>{
            this.userData = result;
            this.loginCheck();
          },
          error=>{
          console.error();
          }
        );
      }
    
      loginCheck()
      {
        if(this.loginForm.value.email == this.userData.email && this.loginForm.value.password == this.userData.pass)
        {
          this.router.navigate(['pages/landing']);
        }
    
        else
          alert("Fail");
      }  
}
