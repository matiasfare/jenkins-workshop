
-- Tabla audit_session
comment on column audit_session.id is 'Clave primaria del registro';
comment on column audit_session.remote_ip is 'Dirección IP de la sesión iniciada con la aplicaición';
comment on column audit_session.user_agent is 'Desripción del navegador desde el cuál se inició la sesión';
comment on column audit_session.user_date is 'Fecha y hora de inicio de sesión obtenida a partir de la petición del usuario';
comment on column audit_session.creation_date is 'Hora y fecha de creación de este registro';
comment on column audit_session.id_principal is 'FK a columna principal_session.id. Identificador del usuario que inició sesión';

-- Tabla consumer_api
comment on column consumer_api.id is 'Clave primaria del registro';
comment on column consumer_api.access_level is 'Nivel de Acceso al API. Valores posibles: N_BEHALF_USER, ON_BEHALF_USER_LAZY, ADMIN';
comment on column consumer_api.consumer_id is 'Identificador del consumidor del API';
comment on column consumer_api.contact_name is 'Nombre de contacto del consumidor del API';
comment on column consumer_api.document_number is 'Cédula del consumidor del API';
comment on column consumer_api.name is 'Nombre del consumidor del API';
comment on column consumer_api.secret is 'Clave para el consumidor del API';

-- Tabla keychain
comment on column keychain.id is 'Clave primaria del registro';
comment on column keychain.value is 'Valor de clave secreta para encriptación de tokens';

-- Tabla security_profile
comment on column security_profile.id is 'Clave primaria del registro';
comment on column security_profile.key is 'Id del perfil de seguridad o aplicación';
comment on column security_profile.access_token_timeout_seconds is 'Tiempo de expiración del access token en segundos';
comment on column security_profile.max_number_devices_user is 'Máximo número de dispositivos por usuario';
comment on column security_profile.max_access_token_requests is 'Máximo número de peticiones por token';
comment on column security_profile.max_number_of_connections is 'Máximo número de conexiones por token';
comment on column security_profile.name is 'Alias del perfil de seguridad o aplicación';
comment on column security_profile.refresh_token_timeout_seconds is 'Tiempo de expiración del refresh token en segundos';
comment on column security_profile.revocable is '1 indica que el token es revocable, 0 en caso contrario';

-- Tabla tokens
comment on column tokens.id is 'Clave primaria del registro';
comment on column tokens.expiration is 'Fecha y hora de expiración del token';
comment on column tokens.issued_at is 'Fecha y hora que fue emitido el token';
comment on column tokens.remote_ip is 'IP remoto para el que fue emitido el token';
comment on column tokens.token_type is 'Tipo de token. Valores posibles; REFRESH, REFRESH_C, ACCESS';
comment on column tokens.user_agent is 'Descripción del navegador para el que fue emitido el token';
comment on column tokens.user_id is 'Identificador del usuario para el que fue emitido el token';
comment on column tokens.security_profile_id is 'FK a security_profile.id. Identificador de perfil de seguridad.';

-- Tabla libpagos_users
comment on column libpagos_users.id is 'Clave primaria del registro';
comment on column libpagos_users.nro_documento is 'Cédula de identidad del usuario';
comment on column libpagos_users.apellido is 'Apellido del usuario';
comment on column libpagos_users.codigo_entidad is 'Código de la entidad de un usuario';
comment on column libpagos_users.entidad is 'Texto descriptivo de la entidad de un usuario';
comment on column libpagos_users.lote is 'Número de lote actualmente abierto por la terminal del usuario';
comment on column libpagos_users.caja is 'Número de la caja del usuario';
comment on column libpagos_users.sucursal is 'Texto descriptivo la sucursal del usuario';
comment on column libpagos_users.id_terminal is 'Identificador de la terminal del usuario';
comment on column libpagos_users.nombre is 'Nombre del usuario';
comment on column libpagos_users.email is 'Correo electrónico del usuario';
comment on column libpagos_users.fecha_nacimiento is 'Fecha de nacimiento del usuario';
comment on column libpagos_users.perfil is 'Perfil del usuario. Cajero o Supervisor';
comment on column libpagos_users.id_persona is 'Identificador del usuario. Puede o no tener el mismo valor que la columna nro_documento';

-- Tabla PRINCIPAL_SESSION
comment on column principal_session.id is 'Identificador del registro';
comment on column principal_session.app_description is 'Descripción de la aplicación que inició una sesión';
comment on column principal_session.app_id is 'Identificador de la aplicación que inició una sesión';
comment on column principal_session.user_description is 'Descripción del usuario que inició una sesión';
comment on column principal_session.user_id is 'Identificador del usuario que inició una sesión';




















