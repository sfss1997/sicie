import { TestBed } from '@angular/core/testing';

import { especializacionService } from './especializacion.service';

describe('EspecializacionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: especializacionService = TestBed.get(especializacionService);
    expect(service).toBeTruthy();
  });
});
