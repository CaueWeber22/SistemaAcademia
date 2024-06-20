use academia;


insert into cargo (id, cargo, salario) values
(1, 'professor', 3500),
(2, 'auxiliar de limpeza', 1900),
(3, 'administrador', 3000),
(4, 'recepcionista', 1700)
;

insert into funcionarios (nome, cpf, data_nascimento, id_cargo, data_admissao) values
('Junior Souza', 74466846073, '1987-11-23', 1, '2019-02-04'),
('Matheus Alencar', 35926072000, '1982-02-11', 4, '2020-04-18'),
('Felipe Gabriel', 87209986006, '1991-09-02', 2, '2019-07-28'),
('Maria Clara', 13050678003, '1995-05-18', 3, '2020-01-23'),
('Renata Azevedo', 16125704025, '1990-07-29', 1, '2021-10-30'),
('João Silva', 78536001003, '2001-03-24', 3, '2019-01-13');

insert into grupos_musculares (id, grupo_muscular) values
(1, 'Peito'),
(2, 'Costas'),
(3, 'Bíceps'),
(4, 'Tríceps'),
(5, 'Pernas'),
(6, 'Panturrilha'),
(7, 'Ombros'),
(8, 'Trapézio'),
(9, 'Abdômen');

insert into exercicios (nome, grupo_musculares_id) values
('Supino com barra', 1),
('Crucifixo máquina', 1),
('Supino inclinado com halteres', 1),
('Crossover', 1),
('Peck deck', 1),
('Pulley frente', 2),
('Remada baixa', 2),
('Barra fixa', 2),
('Remada curvada com barra', 2),
('Remada unilateral com halter', 2),
('Agachamento com barra livre', 5),
('Leg press 45 graus', 5),
('Cadeira extensora', 5),
('Mesa flexora', 5),
('Hack machine', 5),
('Cadeira abdutora', 5),
('Elevação de panturrilha', 6),
('Rosca direta com barra', 3),
('Rosca concentrada', 3),
('Rosca scott', 3),
('Rosca alternada', 3),
('Rosca martelo' , 3),
('Tríceps testa' , 4),
('Tríceps francês', 4),
('Tríceps na polia com barra', 4),
('Tríceps com corda na polia', 4),
('Mergulho nas paralelas', 4),
('Elevação lateral', 7),
('Desenvolvimento articulado', 7),
('Desenvolvimento com halteres', 7),
('Remada alta', 7),
('Encolhimento', 8),
('Elevação frontal', 7),
('Abdominal supra', 9),
('Prancha', 9),
('Abdominal infra', 9),
('Roda abdominal', 9);

insert into treino (id, nome, numero_divisoes, descricao, descricao_dias) values
(1, 'treino 5 dias na semana', '5', 'aaa', 'aaa');

insert into exercicios_treinos (id_exercicios, id_treinos, divisao, series, repeticoes) values
(1, 1, 'A', 4, 12),
(3, 1, 'A', 4, 12),
(4, 1, 'A', 4, 12),
(5, 1, 'A',  4, 12),
(34, 1, 'A', 4, 12),
(36, 1, 'A', 4, 12),
(37, 1, 'A', 4, 12),
(6, 1, 'B',  4, 12),
(8, 1, 'B', 4, 12),
(7, 1, 'B', 4, 12),
(9, 1, 'B',  4, 12),
(13, 1, 'C', 4, 12),
(11, 1, 'C', 4, 12),
(12, 1, 'C',4, 12),
(14, 1, 'C', 4, 12),
(15, 1, 'C', 4, 12),
(17, 1, 'C', 4, 12),
(23, 1, 'D', 4, 12),
(25, 1, 'D',  4, 12),
(24, 1, 'D', 4, 12),
(26, 1, 'D', 4, 12),
(18, 1, 'D', 4, 12),
(20, 1, 'D',  4, 12),
(21, 1, 'D',  4, 12),
(22, 1, 'D',4, 12),
(28, 1, 'E', 4, 12),
(30, 1, 'E', 4, 12),
(31, 1, 'E', 4, 12),
(33, 1, 'E', 4, 12),
(32, 1, 'E',  4, 12),
(34, 1, 'E',  4, 15),
(36, 1, 'E', 4, 15),
(37, 1, 'E', 4, 15);

insert into planos (id, nome, tempo_plano) values
(1, 'mensal', '1 mês'),
(2, 'trimestral', '3 meses'),
(3, 'semestral', '6 meses'),
(4, 'anual', '12 meses');

insert into usuarios (nome,cpf, data_nascimento, plano_id) values
('Pedro Henrique', 85212320046, '1995-02-16', 2),
('Ana Clara', 78977474094, '1999-04-23',  3),
('Eduardo Oliveira', 26858205071,'2000-10-01', 4),
('Kauan Henrique', 54321797098, '1985-09-11', 4),
('Jessica Pereira', 60330759000, '1991-01-05', 3),
('André Dutra', 22083190017, '2002-06-12', 2),
('Claudio Nascimento', 36359325071, '1999-08-16', 1),
('Cibele Carvalho', 15965767072, '1989-12-02', 2),
('Daniel Freire', 30481598006, '1991-04-24', 1),
('Alexandre Félix', 61178248070, '1997-10-05', 1),
('Emilly Vitória', 48881083078, '2002-09-08', 2),
('Evandro Gomes', 36694006055, '1994-06-16', 3),
('Felipe Oliveira', 51123423075, '2005-01-29', 3);


update usuarios set treino_id = 1 where id_carteirinha = 1 or id_carteirinha = 3 or id_carteirinha = 7 
or id_carteirinha = 11;

update usuarios set ativo = true where id_carteirinha = 1 or id_carteirinha = 3 or id_carteirinha = 7 
or id_carteirinha = 11;

