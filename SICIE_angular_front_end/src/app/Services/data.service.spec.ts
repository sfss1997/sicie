import { TestBed, inject } from '@angular/core/testing';

import { recintoDataService } from './data.service';

describe('recintoDataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [recintoDataService]
    });
  });

  it('should be created', inject([recintoDataService], (service: recintoDataService) => {
    expect(service).toBeTruthy();
  }));
});