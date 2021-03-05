# Lab 3: ORM, Hibernate, JPA, and Spring

### What this application does:

This application creates a User, Employee, Leaves, Benefits tables and join them on different ways:
* OneToMany relationship with lazy load
* ManyToMany with lazy load
* ManyToOne with eager loading
* OneToOne with eager loading

It also implements caching.

Dummy data is added into tables and can be found in `resources/data.sql` folder.


## Challenge Tasks
### a. 
Loading data is skipped. Since the cache has been increased by 20s to live, by the time we wait 10s, the data is still there so there is no need to load again.

### b.
I managed to do this by basicall making the employee table primary with generated ID and changing how data.sql added data into tables

### c.
From what I understand is, if using cascade.remove, it will remove any child when the parent is deleted. E.g User parent and Employee child

For orphan removal, it will remove the child if the parent no longer links to its child. The child becomes an orphan and is removed
### d.

Now benefits loads every employee (3 of them) that's referenced in its table while address attempts to load employees

### e.
Logically addresses will not be removed when removing employees.
Benefit doesn't have cascade = cascadeType.ALL and orphanRemoval = true?

### f.
I get the error "No EntityManager with actual transaction available for current thread - cannot reliably process 'persist' call"
The annotation Transactional makes handling session and transactions easy in Spring, removing the need for redundant error handling and such.
After quick research, Spring has Persistence Context defaulted to transactional https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#orm, which is why we need those annotations
I do not really understand this, but hope I will


