import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class DataService {

  constructor(public http:HttpClient) { }

  res:any;
  baseUrl = 'http://localhost:8080/users/';
  
  
  getLoginDetailsUsingUnameOrEmail(email)
  {
    let url = this.baseUrl+"login/"+email;
    console.log(url);
    return this.http.get(url);
  }

  registerUser(user)
  {
    let url = this.baseUrl+"create";
    console.log(user);
    console.log(url);
    console.log(this.http.post(url, user));
    return this.http.post(url, user);
  }

}
