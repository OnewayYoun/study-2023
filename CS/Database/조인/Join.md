## DATABASE Join

 ### Join이란?
 
 * 관계형 데이터베이스는 중복 데이터를 피하기 위해 데이터를 여러개의 테이블로 나눠서 저장한다
 * 분리 저장된 데이터를 이용자가 필요한대로 다시 사용하기 위해 여러 테이블을 조합해야할 때 Join을 사용한다
 
 ### Join의 종류
 * INNER Join
	* 2개의 테이블(A,B)의 컬럼 값을 결합함으로써 새로운 결과 테이블을 생성
	* 교집합으로 기준 테이블과 Join 테이블의 중복된 값을 나타냄
	* ex) SELECT * FROM user (INNER) JOIN content ON user.id=content.userId
	
 * Outer Join
	* Left Outer Join & Right Outer Join
		* 기준테이블을 명시함
		* 기준테이블의 값을 기준으로 조인하고, 조인하는 다른 테이블에 없는 값은 Null로 표현
		* ex ) SELECT * FROM user LEFT JOIN content ON user.id=content.userId
	*Full Outer Join
		* 조인하는 두 테이블의 모든 값을 유지하고 값이 없으면 Null 표현
		* ex) SELECT * FROM employee FULL OUTER JOIN department ON employee.DepartmentID = department.DepartmentID;
		
  * Cross Join
   * 조인 되는 두 테이블의 곱집합 테이블
   * m행을 가진 테이블과 n행을 가진 테이블이 교차 조인되면 m*n 개의 행을 가진 테이블이 생성
   * ex) SELECT * FROM employee CROSS JOIN department
   
  * Self Join
   * 자기 자신과 테이블 Join
   * 같은 테이블을 사용하기 때문에 alias 지정이 필요함
   * select e1.mgr, e2.ename, e1.empno, e1.ename from emp e1 join emp e2 on e1.mgr=e2.empno;
   
   
  ### Join의 원리
  
   * Nested loops
		* 외부 테이블의 각 행에 대해 내부 테이블의 모든 행을 순차적으로 검색하며, 조인
		1. 선행 테이블에서 조건을 만족하는 첫 번째 행을 찾음 → 이때 선행 테이블에 주어진 조건을 만족하지 않는 경우 해당 데이터는 필터링 됨 
		2. 선행 테이블의 조인 키를 가지고 후행 테이블에 조인 키가 존재하는지 찾으러 감 → 조인 시도 
		3. 후행 테이블의 인덱스에 선행 테이블의 조인 키가 존재하는지 확인 → 선행 테이블의 조인 값이 후행 테이블에 존재하지 않으면 선행 테이블 데이터는 필터링 됨 (더 이상 조인 작업을 진행할 필요 없음) 
		4. 인덱스에서 추출한 레코드 식별자를 이용하여 후행 테이블을 액세스 → 인덱스 스캔을 통한 테이블 액세스 후행 테이블에 주어진 조건까지 모두 만족하면 해당 행을 추출버퍼에 넣음 
   * Sort Merge
		* 두 테이블을 조인 조건의 키 값으로 미리 정렬한 후, 두 테이블의 행을 순차적으로 비교하며 조인을 수행
		1. 선행 테이블에서 주어진 조건을 만족하는 행을 찾음 
		2. 선행 테이블의 조인 키를 기준으로 정렬 작업을 수행 1 ~ 2번 작업을 선행 테이블의 조건을 만족하는 모든 행에 대해 반복 수행 
		3. 후행 테이블에서 주어진 조건을 만족하는 행을 찾음 
		4. 후행 테이블의 조인 키를 기준으로 정렬 작업을 수행 3 ~ 4번 작업을 후행 테이블의 조건을 만족하는 모든 행에 대해 반복 수행 
		5. 정렬된 결과를 이용하여 조인을 수행하며 조인에 성공하면 추출버퍼에 넣음
   * Hash Join
		* 하나의 테이블 (보통 작은 테이블)을 사용하여 해시 테이블을 생성하고, 다른 테이블을 스캔하며 해당 해시 테이블과 매칭되는 항목을 찾아 조인
		1. 선행 테이블에서 주어진 조건을 만족하는 행을 찾음 
		2. 선행 테이블의 조인 키를 기준으로 해쉬 함수를 적용하여 해쉬 테이블을 생성 → 조인 칼럼과 SELECT 절에서 필요로 하는 칼럼도 함께 저장됨 1 ~ 2번 작업을 선행 테이블의 조건을 만족하는 모든 행에 대해 반복 수행 
		3. 후행 테이블에서 주어진 조건을 만족하는 행을 찾음 
		4. 후행 테이블의 조인 키를 기준으로 해쉬 함수를 적용하여 해당 버킷을 찾음 → 조인 키를 이용해서 실제 조인될 데이터를 찾음 
		5.  조인에 성공하면 추출버퍼에 넣음 3 ~ 5번 작업을 후행 테이블의 조건을 만족하는 모든 행에 대해서 반복 수행
   