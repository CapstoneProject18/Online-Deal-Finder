import { Injectable, ElementRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {
  AuthService,
  GoogleLoginProvider
} from 'angular-6-social-login';
import { Router } from '@angular/router';

@Injectable()
export class DataService {

  constructor(public http:HttpClient, private socialAuthService:AuthService, private router:Router) { }

  res:any;
  baseUrl = 'http://localhost:8080/';

  getLoginDetailsUsingUnameOrEmail(email)
  {
    let url = this.baseUrl+"users/loginBuyer/"+email;
    console.log(url);
    return this.http.get(url);
  }

  registerUser(user, image:File)
  {
    let url = this.baseUrl+"users/createBuyer";
    const formData = new FormData();

    formData.append('image', image);
    formData.append('name', user.name);
    formData.append('email', user.email);
    formData.append('pass', user.pass);

    return this.http.post(url, formData);
  }

  registerGoogleUser(platform:string)
  {
    let socialPlatformProvider;
      if(platform == "google"){
        socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
      }
      
      this.socialAuthService.signIn(socialPlatformProvider).then(
        (userData) => {
          console.log(userData);            
        this.router.navigate(['pages/landing']); 
        }
      );  
  }

  addItemToDatabase(item, image:File)
  {
    let url = this.baseUrl+"users/createProduct";
    const formData = new FormData();

    formData.append('image', image);
    formData.append('name', item.pName);
    formData.append('email', item.pPrice);

    return this.http.post(url, formData);
  }
}
