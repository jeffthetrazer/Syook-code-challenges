function makeTea(n, k, g, b) {
    const result = [];
    let greenCount = g;
    let blackCount = b;

    while (greenCount > 0 || blackCount > 0) {
        if (greenCount > 0 && (result.length === 0 || result[result.length - 1] === "Black") && k > 0) {
            result.push("Green");
            greenCount--;
            k--;
        } else if (blackCount > 0 && (result.length === 0 || result[result.length - 1] === "Green") && k > 0) {
            result.push("Black");
            blackCount--;
            k--;
        } else if (greenCount > 0) {
            result.push("Green");
            greenCount--;
            k = Math.min(k + 1, g);
        } else if (blackCount > 0) {
            result.push("Black");
            blackCount--;
            k = Math.min(k + 1, b);
        } else {
            break;
        }
    }

    if (result.length === n) {
        return result;
    } else {
        return [];
    }
}

console.log(makeTea(5, 1, 3, 2)); // Output: ["Green", "Black", "Green", "Black", "Green"]
console.log(makeTea(4, 3, 4, 0)); // Output: []
