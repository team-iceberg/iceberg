import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {SpinnerStore} from '../../tools/stores/spinner/spinner.store';
import {SpinnerComponent} from './spinner.component';

describe('SpinnerComponent', () => {
    let fixture: ComponentFixture<SpinnerComponent>;
    let component: SpinnerComponent;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [SpinnerComponent],
            providers: [
                {provide: SpinnerStore, useValue: jasmine.createSpyObj('SpinnerStore', ['isLoading'])}
            ]
        }).overrideTemplate(SpinnerComponent, '')
            .compileComponents().then(() => {
            fixture = TestBed.createComponent(SpinnerComponent);
            component = fixture.debugElement.componentInstance;
        });
    }));

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
