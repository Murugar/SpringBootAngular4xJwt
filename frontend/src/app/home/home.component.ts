import { Component, OnInit } from '@angular/core';
import {
  FooService,
  ConfigService,
  UserService
} from '../service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  fooResponse = {};
  whoamIResponse = {};
  allUserResponse = {};
  
  constructor(
    private config: ConfigService,
    private fooService: FooService,
    private userService: UserService
  ) { }

  ngOnInit() {
  }

  makeRequest(path) {
    if (path === this.config.foo_url) {
      this.fooService.getFoo()
      .subscribe(res => {
        this.ResponseObj(this.fooResponse, res, path);
      }, err => {
        this.ResponseObj(this.fooResponse, err, path);
      });
    } 
    else if (path === this.config.foo_sorted_url) {
        this.fooService.getFooSorted()
        .subscribe(res => {
          this.ResponseObj(this.fooResponse, res, path);
        }, err => {
          this.ResponseObj(this.fooResponse, err, path);
        });
      }
    
    else if (path === this.config.whoami_url) {
      this.userService.getMyInfo()
      .subscribe(res => {
        this.ResponseObj(this.whoamIResponse, res, path);
      }, err => {
        this.ResponseObj(this.whoamIResponse, err, path);
      });
    } else {
      this.userService.getAll()
      .subscribe(res => {
        this.ResponseObj(this.allUserResponse, res, path);
      }, err => {
        this.ResponseObj(this.allUserResponse, err, path);
      });
    }
  }

  ResponseObj(obj, res, path) {
    obj['path'] = path;
    obj['method'] = 'GET';
    if (res.ok === false) {
      // err
      obj['status'] = res.status;
      try {
        obj['body'] = JSON.stringify(JSON.parse(res._body), null, 2);
      } catch (err) {
        obj['body'] = res._body;
      }
    } else {
      // 200
      obj['status'] = 200;
      obj['body'] = JSON.stringify(res, null, 2);
    }
  }

}
