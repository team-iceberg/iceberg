import {SpinnerStore} from './spinner.store';

describe('SpinnerStore', () => {
    let store: SpinnerStore;

    beforeEach(() => {
        store = new SpinnerStore();
    });

    it('should be created', () => {
        expect(store).toBeTruthy();
    });
});
