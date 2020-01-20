import {Component, EventEmitter, Input, Output} from '@angular/core';
import {User} from '../../models/user';

@Component({
    selector: 'header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.less']
})

export class HeaderComponent {

    @Input()
    public user: User;

    @Output()
    public logoutEvent: EventEmitter<void>;

    constructor() {
        this.logoutEvent = new EventEmitter();
    }


    logout() {
        this.logoutEvent.emit();
    }

    isLoggedIn(): boolean {
        return this.user != null;
    }
}
