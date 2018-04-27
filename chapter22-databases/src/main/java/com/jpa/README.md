 

http://127.0.0.1:9090/druid/index.html  driud  123456 


springboot1.x和springboot2.x里面多数救援踩坑



配置文件：url: jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8   （springboot1.x）
          jdbc-url: jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8   （springboot2.x）



BookDataSourceConfigurer：
    LocalContainerEntityManagerFactoryBean方法
                 //.properties(getVendorProperties(bookDataSource))//（springboot1.X）
                   .properties(getVendorProperties())//（springboot2.X）
                   
              //获取jpa配置信息 springboot1.X
                private Map<String, String> getVendorProperties(DataSource dataSource) {
                   return jpaProperties.getHibernateProperties(dataSource);
               }
            
                //获取jpa配置信息 springboot2.X
                private Map<String, Object> getVendorProperties() {
                    return jpaProperties.getHibernateProperties(new HibernateSettings());
                }

然后就是引入的包的问题