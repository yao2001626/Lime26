; ModuleID = '/home/yaos4/Lime26/input/Sleigh.c'
source_filename = "/home/yaos4/Lime26/input/Sleigh.c"
target datalayout = "e-m:e-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

%struct.Sleigh_struct = type { i32, i32, i32, i32, i32, i32, %struct.Santa_struct* }
%struct.Santa_struct = type opaque

; Function Attrs: noinline nounwind optnone uwtable
define void @Sleigh_back(%struct.Sleigh_struct*, i8*) #0 {
  %3 = alloca %struct.Sleigh_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Sleigh_struct* %0, %struct.Sleigh_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %5, i32 0, i32 5
  %7 = load i32, i32* %6, align 4
  %8 = sub nsw i32 %7, 1
  %9 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %10 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %9, i32 0, i32 5
  store i32 %8, i32* %10, align 4
  %11 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %12 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %11, i32 0, i32 5
  %13 = load i32, i32* %12, align 4
  %14 = icmp eq i32 %13, 0
  br i1 %14, label %15, label %24

; <label>:15:                                     ; preds = %2
  %16 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %17 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %16, i32 0, i32 4
  store i32 6, i32* %17, align 8
  %18 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %19 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %18, i32 0, i32 5
  store i32 9, i32* %19, align 4
  %20 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %21 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %20, i32 0, i32 6
  %22 = load %struct.Santa_struct*, %struct.Santa_struct** %21, align 8
  %23 = load i8*, i8** %4, align 8
  call void @Santa_back(%struct.Santa_struct* %22, i8* %23)
  br label %24

; <label>:24:                                     ; preds = %15, %2
  ret void
}

declare void @Santa_back(%struct.Santa_struct*, i8*) #1

; Function Attrs: noinline nounwind optnone uwtable
define void @Sleigh_harness(%struct.Sleigh_struct*, i8*) #0 {
  %3 = alloca %struct.Sleigh_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Sleigh_struct* %0, %struct.Sleigh_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %5, i32 0, i32 5
  %7 = load i32, i32* %6, align 4
  %8 = sub nsw i32 %7, 1
  %9 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %10 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %9, i32 0, i32 5
  store i32 %8, i32* %10, align 4
  %11 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %12 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %11, i32 0, i32 5
  %13 = load i32, i32* %12, align 4
  %14 = icmp eq i32 %13, 0
  br i1 %14, label %15, label %24

; <label>:15:                                     ; preds = %2
  %16 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %17 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %16, i32 0, i32 4
  store i32 7, i32* %17, align 8
  %18 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %19 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %18, i32 0, i32 5
  store i32 9, i32* %19, align 4
  %20 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %21 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %20, i32 0, i32 6
  %22 = load %struct.Santa_struct*, %struct.Santa_struct** %21, align 8
  %23 = load i8*, i8** %4, align 8
  call void @Santa_harness(%struct.Santa_struct* %22, i8* %23)
  br label %24

; <label>:24:                                     ; preds = %15, %2
  ret void
}

declare void @Santa_harness(%struct.Santa_struct*, i8*) #1

; Function Attrs: noinline nounwind optnone uwtable
define void @Sleigh_pull(%struct.Sleigh_struct*, i8*) #0 {
  %3 = alloca %struct.Sleigh_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Sleigh_struct* %0, %struct.Sleigh_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %5, i32 0, i32 5
  %7 = load i32, i32* %6, align 4
  %8 = sub nsw i32 %7, 1
  %9 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %10 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %9, i32 0, i32 5
  store i32 %8, i32* %10, align 4
  %11 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %12 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %11, i32 0, i32 5
  %13 = load i32, i32* %12, align 4
  %14 = icmp eq i32 %13, 0
  br i1 %14, label %15, label %24

; <label>:15:                                     ; preds = %2
  %16 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %17 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %16, i32 0, i32 4
  store i32 5, i32* %17, align 8
  %18 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %19 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %18, i32 0, i32 5
  store i32 9, i32* %19, align 4
  %20 = load %struct.Sleigh_struct*, %struct.Sleigh_struct** %3, align 8
  %21 = getelementptr inbounds %struct.Sleigh_struct, %struct.Sleigh_struct* %20, i32 0, i32 6
  %22 = load %struct.Santa_struct*, %struct.Santa_struct** %21, align 8
  %23 = load i8*, i8** %4, align 8
  call void @Santa_pull(%struct.Santa_struct* %22, i8* %23)
  br label %24

; <label>:24:                                     ; preds = %15, %2
  ret void
}

declare void @Santa_pull(%struct.Santa_struct*, i8*) #1

attributes #0 = { noinline nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #1 = { "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }

!llvm.module.flags = !{!0}
!llvm.ident = !{!1}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{!"clang version 6.0.0-1ubuntu2 (tags/RELEASE_600/final)"}
