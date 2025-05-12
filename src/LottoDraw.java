public class LottoDraw {
    public static void main(String[] args) {

        // Step 1: generate 40 lottery numbers
        StrLinkedList lotteryNumbers = StrLinkedList.generateLotteryNumbers();
        System.out.print("lottery numbers：");
        lotteryNumbers.print(); 

        // Step 2: choose 6 winning numbers
        StrLinkedList winningNumbers = StrLinkedList.pickWinningNumbers(lotteryNumbers);
        System.out.print("win number：");
        winningNumbers.print();  // winning numbers

        // Step 3: simulate 100 tickets
        //100 tickets
        double totalPrizePool = 0.0;
        double totalSales = 0.0;
        int numTickets = 100;
        for (int i = 0; i < numTickets; i++) {
            StrLinkedList ticket = StrLinkedList.generateTicket(lotteryNumbers);
            int matches = StrLinkedList.calculateMatches(ticket, winningNumbers);
            double prize = StrLinkedList.calculatePrize(matches);
            totalPrizePool += prize;
            totalSales += 10.00;  //he cost of a ticket=10 每张彩票售价 $10.00
        }

        // Step 4: 计算并显示总销售额和利润
        double profit = totalSales - totalPrizePool;
        System.out.println("\n100 Lotto Total sales：" + totalSales);
        System.out.println("total Prize Pool：" + totalPrizePool);
        System.out.println("fundraising profit：" + profit);
    }
}
