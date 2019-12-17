import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

import {environment} from '../../../../environments/environment';

@Injectable()
export class UrlInterceptor implements HttpInterceptor {

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let url: string;
        if (req.url.indexOf('i18n') === -1) {
            url = `${environment.BACKEND_BASE_URL}${req.url}`;
        } else {
            url = `${environment.BASE_URL}${req.url}`;
        }

        const newRequest = req.clone({url});
        return next.handle(newRequest);
    }
}
