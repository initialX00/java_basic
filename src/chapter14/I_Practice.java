package chapter14;

//직원 관리 시스템

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//직원 목록 필터링 & 정렬
@AllArgsConstructor
@Getter
@ToString
class Employee {
    private String department;
    private String name;
    private double salary;
}

public class I_Practice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("IT", "이씨", 5000),
                new Employee("HR", "조씨", 8000),
                new Employee("IT", "김씨", 6500),
                new Employee("Finance", "전씨", 4000),
                new Employee("HR", "윤씨", 5700)
        );

        //1.급여가 6000 이상인 직원 필터링
        List<Employee> filteredEployee = employees.stream()
                .filter(employee -> employee.getSalary() >= 6000)
                .collect(Collectors.toList());
        filteredEployee.forEach(System.out::println);
        //2.IT부서 직원의 이름만 추출
        List<String> itEmployeeNames = employees.stream()
                .filter(employee -> "IT".equals(employee.getDepartment()))
                .map(Employee::getName)
                .collect(Collectors.toList());
        itEmployeeNames.forEach(System.out::println);

        //3.특정 부서(HR) 직원 중 이름에 '조'가 포함된 직원 필터링
        List<Employee> employeesJo = employees.stream()
                .filter(employee -> employee.getDepartment().equals("HR"))
                .filter(employee -> employee.getName().contains("조"))
                .collect(Collectors.toList());
        employeesJo.forEach(System.out::println); //Employee(department=HR, name=조씨, salary=8000.0)

        //4.부서별 직원 그룹화
        Map<String, List<Employee>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(employeesByDept);
        //{Finance=[Employee(department=Finance, name=전씨, salary=4000.0)],
        // HR=[Employee(department=HR, name=조씨, salary=8000.0), Employee(department=HR, name=윤씨, salary=5700.0)],
        // IT=[Employee(department=IT, name=이씨, salary=5000.0), Employee(department=IT, name=김씨, salary=6500.0)]}

        //5.부서별 평균 급여 계산
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
//        Map<String, Double> avgSalaryByDept = employees.stream()
//                .collect(Collectors.groupingBy(employee -> employee.getDepartment,
//                        Collectors.averagingDouble(employee -> employee.getSalary)));
        System.out.println(avgSalaryByDept); //{Finance=4000.0, HR=6850.0, IT=5750.0}

    }
}
