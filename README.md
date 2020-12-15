# Meep-Test
Realización de un microservicio que haga polling contra un endpoint predeterminado que devuelve recursos, en un área determinada de Lisboa.

El microservicio realiza el polling contra este servicio cada medio minuto y en cada pasada localiza los recursos que han quedado libres y los muestra por log. Una mejora de este micro consistiría en inyectar estos datos de nuevos vehículo por un stream de eventos para que fuese consumido por otro servicio que los pasase a una GUI o similar. Esta parte no se ha implementado.

Se utiliza un redis para poder mantener el estado de los vehículos en todo momento y por velocidad de consulta y actualización. En pricipio se ha utilizado una imagen de docker de Redis, arrancada en su puerto por defecto (6379) por lo que, para poder ejecutar el micro, es necesario tener arrancada esta imagen. 

Por temas de sencillez y tiempo no se ha dockerizado este servicio, se podría haber montado una pequeña infraestructura con las imágenes del servicio y Redis, por ejemplo con Kubernetes, Compose o Swarm.

Igualmente, se podría haber montado una API de consulta con REST o gRPC. a través de un Istio, etc... al final he ido a lo más sencillo.



