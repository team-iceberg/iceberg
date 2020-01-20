import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {AdminComponent} from './admin.component';

describe('AdminComponent', () => {

    let fixture: ComponentFixture<AdminComponent>;
    let component: AdminComponent;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [AdminComponent]
        }).overrideTemplate(AdminComponent, '')
            .compileComponents().then(() => {
            fixture = TestBed.createComponent(AdminComponent);
            component = fixture.debugElement.componentInstance;
        });
    }));

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
