## Invalidando cache de forma dininâmica

O cache é feito normalmente usando `@Cacheable`

```java

@Cacheable( cacheNames = "NAME", key = "{#key1,#key2}")
public AddressVO findAddress(String key1, String key2){
    //code
    ....
}

``` 
Para invalidar vários caches de uma vez usando algum trexo da chave.

Exemplo:

Precisamos invalidar todos os caches cujo sua chave inicia com valor 'key1'

```java
public void invalidCacheCodePostal(String codePostal){
    redisTemplate.keys("NAME::"+codePostal+"*")
        .stream()
        .forEach(k -> redisTemplate.delete(k));
}
```

No método acima a variável redisTemplate é uma instância de `StringRedisTemplate`.

Estamos usando o StringRedisTemplate` para encontrar todas as key's.

> Obs: o valor 'NAME' que está no parâmentro de entrada é o mesmo passado no 'cacheNames' do `@Cacheable`
