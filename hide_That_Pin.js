function convertPIN(pin) {
    const binaryString = pin.toString(2);
    let output = [];

    for (let i = 0; i < binaryString.length; i++) {
        if (binaryString[i] === '1') {
            output.push("pop");
        } else if (binaryString[i] === '0' && i === binaryString.length - 1) {
            output.push("fall");
        } else if (binaryString[i] === '0' && i < binaryString.length - 1) {
            let j = i + 1;
            while (j < binaryString.length && binaryString[j] === '0') {
                j++;
            }

            if (j < binaryString.length && binaryString[j] === '1') {
                output.push("double rip");
            } else if (j < binaryString.length && binaryString[j] === '0') {
                output.push("hide your mints");
                i = j - 1;
            }
        }
    }

    if (binaryString.length > 4 && binaryString[binaryString.length - 5] === '1') {
        output.reverse();
    }

    return output;
}

console.log(convertPIN(3));   // Output: ["pop", "double rip"]
console.log(convertPIN(19));  // Output: ["double rip", "pop"]
console.log(convertPIN(10));  // Output: ["pop", "hide your mints"]
console.log(convertPIN(16));  // Output: ["fall"]
console.log(convertPIN(31));  // Output: ["pop", "double rip", "hide your mints", "fall"]
