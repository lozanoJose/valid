import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { map } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({
    'Accept': 'application/json'
  }),
};


@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) {
    console.log('Spotify Service Listo');
  }

  getQuery( query: string ) {

    const url = `http://localhost:9090${ query }`;
    console.log(url)
    return this.http.get(url, httpOptions);

  }

  postQuery( query: string, object: any ) {

    const url = `http://localhost:9090${ query }`;
    console.log(url)
    return this.http.post(url, object);

  }


  putQuery( query: string, object: any ) {

    const url = `http://localhost:9090${ query }`;
    console.log(url)
    return this.http.put(url, object);

  }


  getClients(url: string) {

    return this.getQuery(url)
              .pipe( map( (data: any) => data ));

  }

  updateClients(url: string, object: any) {

    return this.putQuery(url, object)
              .pipe( map( (data: any) => data ));

  }

  saveClients(url: string, object: any) {

    return this.postQuery(url, object)
              .pipe( map( (data: any) => data ));

  }


}
