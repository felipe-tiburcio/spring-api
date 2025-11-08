ALTER TABLE
  medicos
ADD
  COLUMN is_active BOOLEAN DEFAULT TRUE;

UPDATE
  medicos
SET
  is_active = TRUE;