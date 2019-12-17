import {SpinnerStore} from '../../stores/spinner/spinner.store';
import {UrlInterceptor} from './url.interceptor';

describe('UrlInterceptor', () => {
    let interceptor: UrlInterceptor;
    let spinnerStoreSpy: jasmine.SpyObj<SpinnerStore>;


    beforeEach(() => {
        spinnerStoreSpy = jasmine.createSpyObj('SpinnerStore', ['activate', 'deactivate']);

        interceptor = new UrlInterceptor(spinnerStoreSpy);
    });

    it('should be created', () => {
        expect(interceptor).toBeTruthy();
    });
});
