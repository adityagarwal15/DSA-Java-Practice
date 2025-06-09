WHILE REVISING, I MADE THESE MISTAKE 

1. forgetting to write sc.close(); at the end of the code it helps to avpid resource leaks
2. Whenever using Math.PI use datatype double because that is only by default not the float
3. the order is also important in this, first check 400-->100-->4
4. when comparing the largest of three numbers remember to put this case - all equal case
5. when calculating avg of three numbers, bracket is imp (a + b + c)/3
6. use of System.out.printf() for .2f or symbols like %, ₹, etc.
float price = 149.99f;
System.out.printf("Price: ₹%.2f%n", price);

7.
