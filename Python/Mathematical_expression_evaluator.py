# Program to evaluate a Mathematical Expression by converting it into a postfix expression and then evaluating it using stack

# Function to check if the character is an operator
def isOperator(x):
    if x == '+' or x == '-' or x == '*' or x == '/' or x == '^':
        return True
    else:
        return False

# Function to return the precedence of the operator
def precedence(x):
    if x == '+' or x == '-':
        return 1
    elif x == '*' or x == '/':
        return 2
    elif x == '^':
        return 3
    return 0

# Function to convert infix expression to postfix expression
def infixToPostfix(exp):
    stack = []
    postfix = []
    for i in exp:
        if i.isalnum():
            postfix.append(i)
        elif i == '(':
            stack.append('(')
        elif i == ')':
            while len(stack) != 0 and stack[-1] != '(':
                postfix.append(stack.pop())
            stack.pop()
        elif isOperator(i):
            while len(stack) != 0 and precedence(i) <= precedence(stack[-1]):
                postfix.append(stack.pop())
            stack.append(i)
    while len(stack) != 0:
        postfix.append(stack.pop())
    return "".join(postfix)

# Function to evaluate the postfix expression
def evaluatePostfix(exp):
    stack = []
    for i in exp:
        if i.isalnum():
            stack.append(int(i))
        else:
            val1 = stack.pop()
            val2 = stack.pop()
            if i == '+':
                stack.append(val2 + val1)
            elif i == '-':
                stack.append(val2 - val1)
            elif i == '*':
                stack.append(val2 * val1)
            elif i == '/':
                stack.append(val2 / val1)
            elif i == '^':
                stack.append(val2 ** val1)
    return stack.pop()

# Function to check if the expression is valid or not
def isValid(exp):
    if exp[0] == '+' or exp[0] == '-' or exp[0] == '*' or exp[0] == '/' or exp[0] == '^':
        return False
    if exp[-1] == '+' or exp[-1] == '-' or exp[-1] == '*' or exp[-1] == '/' or exp[-1] == '^':
        return False
    for i in range(len(exp) - 1):
        if exp[i] == '(' and exp[i + 1] == ')':
            return False
        if exp[i] == '(' and exp[i + 1] == '(':
            return False
        if exp[i] == ')' and exp[i + 1] == ')':
            return False
        if exp[i] == ')' and exp[i + 1] == '(':
            return False
        if isOperator(exp[i]) and isOperator(exp[i + 1]):
            return False
    return True

# Driver Code
if __name__ == "__main__":
    exp = input("Enter the expression: ")
    if isValid(exp):
        postfix = infixToPostfix(exp)
        print("Result: ", evaluatePostfix(postfix))
    else:
        print("Invalid Expression")