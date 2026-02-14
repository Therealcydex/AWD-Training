# RULES.md — AWD-Training Project Working Rules

Use this file as a **project brief + execution rules** whenever we continue building this application.

## 1) Mission
Build and evolve this repository as a **microservices training project** composed of:
- Spring Boot backend microservices + Eureka + API Gateway
- Angular frontend consuming the gateway

Always preserve the existing architecture and naming style unless explicitly asked to refactor.

## 2) Repository architecture (must be respected)
- `backend/eureka`: Service discovery server (Eureka)
- `backend/gateway`: API Gateway (Spring Cloud Gateway)
- `backend/microservices/candidat`: Candidat microservice
- `backend/microservices/job`: Job microservice
- `backend/microservices/canditature`: Candidature microservice (spelling in repo is `canditature`)
- `backend/microservices/notification`: Notification microservice
- `backend/microservices/meeting`: Meeting microservice
- `frontEnd/JobBoardAngular`: Angular frontend
- `documentation/`: architecture and workshop documentation

Do not move modules across folders without a clear migration plan.

## 3) Runtime topology and ports
Expected local ports:
- Eureka: `8761`
- Gateway: `8080`
- Candidat: `8081`
- Job: `8082`
- Canditature: `8083`
- Notification: `8084`
- Meeting: `8085`
- Angular dev server: `4200`

Gateway is the only backend entry point used by frontend clients.

## 4) Routing conventions
Gateway routes currently map by path prefix:
- `/mic1/**` -> CANDIDAT
- `/mic2/**` -> JOB
- `/mic3/**` -> CANDIDATURE
- `/mic4/**` -> NOTIFICATION
- `/mic5/**` -> MEETING

Keep route prefixes stable to avoid breaking frontend/service contracts.

## 5) Development rules
1. Start services in this order for local runs:
   1) Eureka
   2) Backend microservices
   3) Gateway
   4) Angular frontend
2. New backend features should be exposed through gateway paths.
3. Prefer minimal, incremental changes (small PRs, clear commit messages).
4. Preserve current technology stack unless asked otherwise:
   - Java 17, Spring Boot, Spring Cloud Gateway, Eureka, Maven
   - Angular
5. Keep naming and package style consistent with existing modules.

## 6) Quality gates for every change
- Backend module touched: run its unit tests with Maven wrapper when possible.
- Frontend touched: run Angular tests/build when possible.
- Validate at least one request path through gateway for changed functionality.

## 7) API extension guidance
When adding a new backend capability:
1. Implement endpoint in the target microservice.
2. Ensure service registration in Eureka is correct.
3. Add/adjust gateway route if needed.
4. Update Angular service calls to hit gateway, not direct microservice URLs.
5. Document new endpoint briefly in `README.md` or module docs.

## 8) Documentation rule
For each non-trivial change, add a short note in docs/README style including:
- What changed
- Where it changed
- How to run/test it

## 9) Important repository-specific notes
- Keep the existing path `canditature` as-is unless a dedicated rename task is requested.
- Current code includes simple `/hello` endpoints used for routing validation; do not remove these smoke-test endpoints unless replacements are provided.

## 10) Definition of done
A change is done when:
- Code compiles/tests pass for touched parts
- Gateway path works for the changed feature
- No module boundaries are unintentionally broken
- Documentation is updated where relevant
