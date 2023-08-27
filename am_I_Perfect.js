function getFactors(num) {
    const factors = [];
    for (let i = 1; i <= Math.sqrt(num); i++) {
        if (num % i === 0) {
            factors.push(i);
            if (i !== num / i) {
                factors.push(num / i);
            }
        }
    }
    return factors.filter(factor => factor !== num);
}

function checkNumberType(num) {
    const factors = getFactors(num);
    const sumOfFactors = factors.reduce((sum, factor) => sum + factor, 0);

    if (sumOfFactors === num) {
        return "Perfect";
    } else if (sumOfFactors > num) {
        return "Abundant";
    } else {
        return "Deficient";
    }
}

console.log(checkNumberType(6));  // Output: "Perfect"
console.log(checkNumberType(12)); // Output: "Abundant"
console.log(checkNumberType(8));  // Output: "Deficient"
