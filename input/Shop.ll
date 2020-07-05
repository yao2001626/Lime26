; ModuleID = '/home/yaos4/Lime26/input/Shop.c'
source_filename = "/home/yaos4/Lime26/input/Shop.c"
target datalayout = "e-m:e-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

%struct.Shop_struct = type { i32, i32, i32, i32, i32, i32, %struct.Santa_struct* }
%struct.Santa_struct = type opaque

; Function Attrs: noinline nounwind optnone uwtable
define void @Shop_puzzled(%struct.Shop_struct*, i8*) #0 {
  %3 = alloca %struct.Shop_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Shop_struct* %0, %struct.Shop_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Shop_struct*, %struct.Shop_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Shop_struct, %struct.Shop_struct* %5, i32 0, i32 5
  %7 = load i32, i32* %6, align 4
  %8 = add nsw i32 %7, 1
  %9 = load %struct.Shop_struct*, %struct.Shop_struct** %3, align 8
  %10 = getelementptr inbounds %struct.Shop_struct, %struct.Shop_struct* %9, i32 0, i32 5
  store i32 %8, i32* %10, align 4
  %11 = load %struct.Shop_struct*, %struct.Shop_struct** %3, align 8
  %12 = getelementptr inbounds %struct.Shop_struct, %struct.Shop_struct* %11, i32 0, i32 5
  %13 = load i32, i32* %12, align 4
  %14 = icmp eq i32 %13, 3
  br i1 %14, label %15, label %22

; <label>:15:                                     ; preds = %2
  %16 = load %struct.Shop_struct*, %struct.Shop_struct** %3, align 8
  %17 = getelementptr inbounds %struct.Shop_struct, %struct.Shop_struct* %16, i32 0, i32 4
  store i32 9, i32* %17, align 8
  %18 = load %struct.Shop_struct*, %struct.Shop_struct** %3, align 8
  %19 = getelementptr inbounds %struct.Shop_struct, %struct.Shop_struct* %18, i32 0, i32 6
  %20 = load %struct.Santa_struct*, %struct.Santa_struct** %19, align 8
  %21 = load i8*, i8** %4, align 8
  call void @Santa_puzzled(%struct.Santa_struct* %20, i8* %21)
  br label %22

; <label>:22:                                     ; preds = %15, %2
  ret void
}

declare void @Santa_puzzled(%struct.Santa_struct*, i8*) #1

; Function Attrs: noinline nounwind optnone uwtable
define void @Shop_enter(%struct.Shop_struct*, i8*) #0 {
  %3 = alloca %struct.Shop_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Shop_struct* %0, %struct.Shop_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Shop_struct*, %struct.Shop_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Shop_struct, %struct.Shop_struct* %5, i32 0, i32 4
  store i32 10, i32* %6, align 8
  %7 = load %struct.Shop_struct*, %struct.Shop_struct** %3, align 8
  %8 = getelementptr inbounds %struct.Shop_struct, %struct.Shop_struct* %7, i32 0, i32 6
  %9 = load %struct.Santa_struct*, %struct.Santa_struct** %8, align 8
  %10 = load i8*, i8** %4, align 8
  call void @Santa_enter(%struct.Santa_struct* %9, i8* %10)
  ret void
}

declare void @Santa_enter(%struct.Santa_struct*, i8*) #1

; Function Attrs: noinline nounwind optnone uwtable
define void @Shop_consult(%struct.Shop_struct*, i8*) #0 {
  %3 = alloca %struct.Shop_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Shop_struct* %0, %struct.Shop_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Shop_struct*, %struct.Shop_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Shop_struct, %struct.Shop_struct* %5, i32 0, i32 5
  %7 = load i32, i32* %6, align 4
  %8 = sub nsw i32 %7, 1
  %9 = load %struct.Shop_struct*, %struct.Shop_struct** %3, align 8
  %10 = getelementptr inbounds %struct.Shop_struct, %struct.Shop_struct* %9, i32 0, i32 5
  store i32 %8, i32* %10, align 4
  %11 = load %struct.Shop_struct*, %struct.Shop_struct** %3, align 8
  %12 = getelementptr inbounds %struct.Shop_struct, %struct.Shop_struct* %11, i32 0, i32 5
  %13 = load i32, i32* %12, align 4
  %14 = icmp sgt i32 %13, 0
  br i1 %14, label %15, label %18

; <label>:15:                                     ; preds = %2
  %16 = load %struct.Shop_struct*, %struct.Shop_struct** %3, align 8
  %17 = getelementptr inbounds %struct.Shop_struct, %struct.Shop_struct* %16, i32 0, i32 4
  store i32 9, i32* %17, align 8
  br label %21

; <label>:18:                                     ; preds = %2
  %19 = load %struct.Shop_struct*, %struct.Shop_struct** %3, align 8
  %20 = getelementptr inbounds %struct.Shop_struct, %struct.Shop_struct* %19, i32 0, i32 4
  store i32 8, i32* %20, align 8
  br label %21

; <label>:21:                                     ; preds = %18, %15
  %22 = load %struct.Shop_struct*, %struct.Shop_struct** %3, align 8
  %23 = getelementptr inbounds %struct.Shop_struct, %struct.Shop_struct* %22, i32 0, i32 6
  %24 = load %struct.Santa_struct*, %struct.Santa_struct** %23, align 8
  %25 = load i8*, i8** %4, align 8
  call void @Santa_consult(%struct.Santa_struct* %24, i8* %25)
  ret void
}

declare void @Santa_consult(%struct.Santa_struct*, i8*) #1

attributes #0 = { noinline nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #1 = { "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }

!llvm.module.flags = !{!0}
!llvm.ident = !{!1}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{!"clang version 6.0.0-1ubuntu2 (tags/RELEASE_600/final)"}
