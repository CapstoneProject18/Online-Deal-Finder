import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormBuilder,Validators, FormGroup, FormControl } from '@angular/forms';
import { DataService } from '../../provider/data.service';
import { Router } from '@angular/router';
import {
  AuthService,
  FacebookLoginProvider,
  GoogleLoginProvider
} from 'angular-6-social-login';


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

    constructor(public data:DataService,
      private formBuilder: FormBuilder,
      private router:Router, 
      private socialAuthService: AuthService,
      private element : ElementRef,
       ) { }

      KEY = 'value';
      value: any = null;
      
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
            email: new FormControl(null, Validators.compose([
              Validators.required,
              Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')
            ])),
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
          alert("Logged In!");
          this.router.navigate(['pages/landing']);
        }
    
        else
          alert("Fail");
      }  

      public socialSignIn(socialPlatform : string) {
        let socialPlatformProvider;
        if(socialPlatform == "google"){
          socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
        }
        
        this.socialAuthService.signIn(socialPlatformProvider).then(
          (userData) => {
            console.log(socialPlatform+" sign in data : " , userData);
            this.router.navigate(['pages/landing']);    
          }
        );
    }
      
}
