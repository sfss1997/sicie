import { TestBed } from '@angular/core/testing';

import { RecintosService } from './recintos.service';

describe('RecintosService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RecintosService = TestBed.get(RecintosService);
    expect(service).toBeTruthy();
  });
});
