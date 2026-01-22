INSERT INTO Client (id, name, email, cpf, idade) VALUES
(1, 'Alice Teste',   'alice@teste.com',   '12345678901', 25),
(2, 'Bob Teste',     'bob@teste.com',     '22222222222', 32),
(3, 'Carol Teste',   'carol@teste.com',   '33333333333', 28),
(4, 'Dave Teste',    'dave@teste.com',    '44444444444', 45),
(5, 'Eve Teste',     'eve@teste.com',     '55555555555', 50)
ON CONFLICT (id) DO NOTHING;